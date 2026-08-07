package com.example.memo.ui.theme

import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import com.example.memo.R

object Font {
    val Nunito = FontFamily(
        Font(R.font.nunito_regular, FontWeight.Normal),
        Font(R.font.nunito_bold, FontWeight.Bold),
        Font(R.font.nunito_black, FontWeight.Black),
        Font(R.font.nunito_light, FontWeight.Light),
        Font(R.font.nunito_medium, FontWeight.Medium),
        Font(R.font.nunito_semibold, FontWeight.SemiBold),
        Font(R.font.nunito_extrabold, FontWeight.ExtraBold),
        Font(R.font.nunito_extralight, FontWeight.ExtraLight),
        Font(R.font.nunito_italic, FontWeight.Normal, FontStyle.Italic),
        Font(R.font.nunito_bold_italic, FontWeight.Bold, FontStyle.Italic),
        Font(R.font.nunito_black_italic, FontWeight.Black, FontStyle.Italic),
        Font(R.font.nunito_light_italic, FontWeight.Light, FontStyle.Italic),
        Font(R.font.nunito_medium_italic, FontWeight.Medium, FontStyle.Italic),
        Font(R.font.nunito_semibold_italic, FontWeight.SemiBold, FontStyle.Italic),
        Font(R.font.nunito_extrabold_italic, FontWeight.ExtraBold, FontStyle.Italic),
        Font(R.font.nunito_extralight_italic, FontWeight.ExtraLight, FontStyle.Italic)
    )

    val GochiHand = FontFamily(
        Font(R.font.gochihand_regular, FontWeight.Normal)
    )

    val OdibeeSans = FontFamily(
        Font(R.font.odibeesans_regular, FontWeight.Normal)
    )
}
