package de.fjure.isd.mycoach.commons.presentation.components


import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import de.fjure.isd.mycoach.ui.theme.Blue
import de.fjure.isd.mycoach.ui.theme.MyCoachTheme

@Composable
fun GenericButton(
    color: Color,
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(modifier = modifier) {
        Button(
            onClick = onClick,
            colors = ButtonDefaults.buttonColors(
                backgroundColor = color,
                contentColor = Color.White
            ),
            shape = RoundedCornerShape(40),
            modifier = Modifier
                .width(350.dp)
                .height(50.dp)
        ) {
            Text(text = text, fontSize = 20.sp)
        }
    }

}

@Preview(showBackground = true)
@Composable
fun GenericButtonPreview() {
    MyCoachTheme {
        GenericButton(color = Blue, text = "Button", onClick = {})
    }
}