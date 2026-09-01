package com.example.memo.modules.home.ui.c

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.material.icons.outlined.Face
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Place
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.math.atan2
import kotlin.math.min
import kotlin.math.sqrt

/**
 * Model describing a single (non-FAB) navigation destination.
 *
 * The bar always shows [selectedIcon] when the item is selected and
 * [unselectedIcon] otherwise -- it never re-tints a single icon.
 */
data class BottomNavigationItem(
    val label: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val contentDescription: String = label,
)

/**
 * Custom [Shape] describing the navigation bar silhouette:
 * - rounded top-left / top-right corners
 * - square bottom-left / bottom-right corners
 * - a concave circular notch cut into the top edge for the FAB
 *
 * All geometry is derived purely from the shape's own measured [Size] plus
 * the supplied Dp parameters -- nothing here is hard-coded in pixels.
 */
private class NotchedNavBarShape(
    private val topCornerRadius: Dp,
    private val fabRadius: Dp,
    private val fabArcGap: Dp,
    private val fabCenterYOffset: Dp, // relative to this shape's top edge (y = 0); typically negative
) : Shape {

    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density,
    ): Outline {
        val path = Path()
        with(density) {
            val w = size.width
            val h = size.height

            val corner = topCornerRadius.toPx().coerceAtMost(min(w, h) / 2f)
            val arcRadius = (fabRadius + fabArcGap).toPx()
            val cx = w / 2f
            val cy = fabCenterYOffset.toPx()

            // Half-width of the notch where the arc meets the flat top edge.
            val dxSquared = arcRadius * arcRadius - cy * cy
            val dx = if (dxSquared > 0f) sqrt(dxSquared) else 0f

            // Start just below the top-left corner.
            path.moveTo(0f, corner)

            // Top-left rounded corner.
            if (corner > 0f) {
                path.arcTo(
                    rect = Rect(0f, 0f, corner * 2f, corner * 2f),
                    startAngleDegrees = 180f,
                    sweepAngleDegrees = 90f,
                    forceMoveTo = false,
                )
            }

            // Flat top edge up to the start of the FAB notch.
            path.lineTo(cx - dx, 0f)

            // Concave arc dipping into the bar to cradle the FAB.
            if (dx > 0f) {
                val angleA = Math.toDegrees(atan2((-cy).toDouble(), (-dx).toDouble())).toFloat()
                val angleB = Math.toDegrees(atan2((-cy).toDouble(), dx.toDouble())).toFloat()
                path.arcTo(
                    rect = Rect(cx - arcRadius, cy - arcRadius, cx + arcRadius, cy + arcRadius),
                    startAngleDegrees = angleA,
                    sweepAngleDegrees = angleB - angleA,
                    forceMoveTo = false,
                )
            }

            // Flat top edge from the end of the notch to the top-right corner.
            path.lineTo(w - corner, 0f)

            // Top-right rounded corner.
            if (corner > 0f) {
                path.arcTo(
                    rect = Rect(w - corner * 2f, 0f, w, corner * 2f),
                    startAngleDegrees = 270f,
                    sweepAngleDegrees = 90f,
                    forceMoveTo = false,
                )
            }

            // Square right / bottom / left edges.
            path.lineTo(w, h)
            path.lineTo(0f, h)
            path.close()
        }
        return Outline.Generic(path)
    }
}

/**
 * A reusable bottom navigation bar with a custom notched shape and a
 * center-sunk circular FAB, built with custom Path geometry (no
 * Material [androidx.compose.material3.NavigationBar]).
 *
 * The bar's height is entirely content-driven (icon size, label size,
 * spacing and [contentPadding]) -- it is never assigned a fixed height.
 * All FAB / arc geometry is derived from [fabSize], [fabSinkFraction]
 * and [fabArcGap]; changing any of those automatically recomputes the
 * notch and FAB position.
 */
@Composable
fun CustomBottomNavigationBar(
    items: List<BottomNavigationItem>,
    selectedIndex: Int,
    onItemSelected: (Int) -> Unit,
    onFabClick: () -> Unit,
    modifier: Modifier = Modifier,

    // FAB
    fabSize: Dp = 63.dp,
    fabColor: Color = MaterialTheme.colorScheme.primary,
    fabElevation: Dp = 6.dp,
    fabContent: @Composable () -> Unit = {
        Icon(
            imageVector = Icons.Default.Add,
            contentDescription = "Add",
            tint = Color.White,
        )
    },

    // Navigation bar
    containerColor: Color = MaterialTheme.colorScheme.surface,
    containerElevation: Dp = 8.dp,

    // Navigation items
    selectedContentColor: Color = MaterialTheme.colorScheme.primary,
    unselectedContentColor: Color = Color.Gray,

    // Layout
    contentPadding: PaddingValues = PaddingValues(horizontal = 12.dp, vertical = 10.dp),
    itemSpacing: Dp = 4.dp,
    /** How many of [items] render to the left of the FAB; the rest render to the right. */
    leftItemCount: Int = (items.size + 1) / 2,

    // FAB / arc relationship
    fabSinkFraction: Float = 0.40f,
    fabArcGap: Dp = 7.dp,

    // Shape
    topCornerRadius: Dp = 32.dp,
) {
    val fabRadius = fabSize / 2

    // How far the FAB sinks below the bar's top edge (diameter-based, dynamic).
    val fabSinkDepth = fabSize * fabSinkFraction

    // FAB center position measured from the bar's top edge (negative = above it).
    val fabCenterYOffset = fabSinkDepth - fabRadius

    // Portion of the FAB that must remain above the bar -- this is exactly the
    // amount of extra space we need to reserve above the bar's top edge.
    val fabOverhang = fabSize - fabSinkDepth

    // Half-width of the notch on the bar's flat top edge, derived from the
    // same geometry used by the shape, so the reserved item space and the
    // drawn notch always agree.
    val arcRadius = fabRadius + fabArcGap
    val dx = run {
        val a = arcRadius.value
        val c = fabCenterYOffset.value
        val sq = a * a - c * c
        if (sq > 0f) sqrt(sq) else 0f
    }.dp
    val centerSpaceWidth = dx * 2

    val shape = remember(topCornerRadius, fabRadius, fabArcGap, fabCenterYOffset) {
        NotchedNavBarShape(
            topCornerRadius = topCornerRadius,
            fabRadius = fabRadius,
            fabArcGap = fabArcGap,
            fabCenterYOffset = fabCenterYOffset,
        )
    }

    val leftItems = items.take(leftItemCount)
    val rightItems = items.drop(leftItemCount)

    Box(modifier = modifier.fillMaxWidth()) {
        Column(modifier = Modifier.fillMaxWidth()) {
            // Reserves exactly the space the FAB needs above the bar.
            Spacer(modifier = Modifier.height(fabOverhang))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .shadow(elevation = containerElevation, shape = shape, clip = false)
                    .background(color = containerColor, shape = shape)
                    .padding(contentPadding),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Row(
                    modifier = Modifier.wrapContentHeight(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(itemSpacing),
                ) {
                    leftItems.forEachIndexed { index, item ->
                        NavItemContent(
                            item = item,
                            selected = items.indexOf(item) == selectedIndex,
                            selectedContentColor = selectedContentColor,
                            unselectedContentColor = unselectedContentColor,
                            onClick = { onItemSelected(items.indexOf(item)) },
                        )
                    }
                }

                Spacer(modifier = Modifier.width(centerSpaceWidth))

                Row(
                    modifier = Modifier.wrapContentHeight(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(itemSpacing),
                ) {
                    rightItems.forEachIndexed { index, item ->
                        NavItemContent(
                            item = item,
                            selected = items.indexOf(item) == selectedIndex,
                            selectedContentColor = selectedContentColor,
                            unselectedContentColor = unselectedContentColor,
                            onClick = { onItemSelected(items.indexOf(item)) },
                        )
                    }
                }
            }
        }

        FloatingActionButton(
            onClick = onFabClick,
            modifier = Modifier
                .align(Alignment.TopCenter)
                .size(fabSize),
            shape = CircleShape,
            containerColor = fabColor,
            elevation = FloatingActionButtonDefaults.elevation(
                defaultElevation = fabElevation,
                pressedElevation = fabElevation,
            ),
        ) {
            fabContent()
        }
    }
}

@Composable
private fun NavItemContent(
    item: BottomNavigationItem,
    selected: Boolean,
    selectedContentColor: Color,
    unselectedContentColor: Color,
    onClick: () -> Unit,
) {
    val color = if (selected) selectedContentColor else unselectedContentColor
    val interactionSource = remember { MutableInteractionSource() }

    Column(
        modifier = Modifier
            .clickable(
                interactionSource = interactionSource,
                indication = ripple(bounded = false, radius = 32.dp),
                onClick = onClick,
            )
            .padding(horizontal = 6.dp, vertical = 2.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(2.dp),
    ) {
        Icon(
            imageVector = if (selected) item.selectedIcon else item.unselectedIcon,
            contentDescription = item.contentDescription,
            tint = color,
            modifier = Modifier.size(24.dp),
        )
        Text(
            text = item.label,
            color = color,
            fontSize = 12.sp,
            textAlign = TextAlign.Center,
        )
    }
}

// ---------------------------------------------------------------------------
// Example usage
// ---------------------------------------------------------------------------

@Composable
private fun CustomBottomNavigationBarExample() {
    val items = remember {
        listOf(
            BottomNavigationItem(
                label = "Home",
                selectedIcon = Icons.Filled.Home,
                unselectedIcon = Icons.Outlined.Home,
            ),
            BottomNavigationItem(
                label = "Calendar",
                selectedIcon = Icons.Filled.DateRange,
                unselectedIcon = Icons.Outlined.DateRange,
            ),
            BottomNavigationItem(
                label = "Map",
                selectedIcon = Icons.Filled.Place,
                unselectedIcon = Icons.Outlined.Place,
            ),
            BottomNavigationItem(
                label = "Gallery",
                selectedIcon = Icons.Filled.Face,
                unselectedIcon = Icons.Outlined.Face,
            ),
        )
    }

    var selectedIndex by remember { mutableStateOf(0) }

    CustomBottomNavigationBar(
        items = items,
        selectedIndex = selectedIndex,
        onItemSelected = { selectedIndex = it },
        onFabClick = { /* handle add action */ },
        modifier = Modifier.fillMaxWidth(),
        fabSize = 63.dp,
        fabColor = Color(0xFFE6285C),
        fabSinkFraction = 0.40f,
        fabArcGap = 7.dp,
        topCornerRadius = 8.dp,
        containerColor = Color.White,
        selectedContentColor = Color(0xFFE6285C),
        unselectedContentColor = Color(0xFFB0B0B0),
        leftItemCount = 2, // 2 items left of the FAB, 2 items right
    )
}

@Preview
@Composable
private fun NavigationBarPreview() {
    CustomBottomNavigationBarExample()
}