package de.fjure.isd.mycoach.commons.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import de.fjure.isd.mycoach.ui.theme.DarkGrey
import de.fjure.isd.mycoach.ui.theme.Ivory
import de.fjure.isd.mycoach.ui.theme.MyCoachTheme

@Composable
fun GenericTextField(
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    MyCoachTheme {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(DarkGrey)
                .wrapContentSize(Alignment.TopCenter)
        ) {

            TextField(
                value = value,
                label = { Text(label) },
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(shape = RoundedCornerShape(30)),
                onValueChange = { onValueChange(it) },
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Ivory,
                    textColor = DarkGrey,
                    cursorColor = DarkGrey,
                )
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GenericTextFieldPreview() {
    MyCoachTheme {
        GenericTextField("Label", "Value", {}, Modifier)
    }
}