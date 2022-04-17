package com.yarenyarsilikal.randompersonlister.ui.main.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.yarenyarsilikal.randompersonlister.domain.model.Person


/**
 * Created by yarenyarsilikal on 16.04.2022.
 */

@Composable
fun PeopleListItem(
    person: Person
) {
    Card(
        modifier = Modifier.padding(vertical = 8.dp, horizontal = 8.dp),
        elevation = 16.dp,
        border = BorderStroke(2.dp, Color.Cyan),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {

            Text(
                text = "${person.id}",
                modifier = Modifier
                    .background(Color.Cyan, CircleShape)
                    .width(64.dp),
                style = MaterialTheme.typography.body1,
                textAlign = TextAlign.Center
            )

            Text(
                text = person.fullName,
                modifier = Modifier.padding(start = 8.dp),
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.body2
            )
        }
    }
}

@Preview
@Composable
fun DifferentLocaleComposablePreview() {
    PeopleListItem(person = Person(5, "Yaren Yarsilikal"))
}