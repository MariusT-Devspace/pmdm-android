package com.example.tarjetadepresentacion

data class ContactInfoItem(
    val icon: Int,
    val info: String,
    val description: String
)

val CONTACT_INFO_DATA = listOf(
    ContactInfoItem(
        R.drawable.call_24dp_1f1f1f_fill1_wght400_grad200_opsz24,
        "(+34) 000 000 000",
        "Phone number"
    ),
    ContactInfoItem(
        R.drawable.mail_24dp_1f1f1f_fill1_wght400_grad200_opsz24,
        "mariustichieru@gmail.com",
        "Email address"
    ),
    ContactInfoItem(
        R.drawable.language_24dp_1f1f1f_fill1_wght400_grad200_opsz24,
        "https://github.com/MariusT-Devspace",
        "Website"
    ),
    ContactInfoItem(
        R.drawable.linkedin,
        "linkedin.com/in/marius-tichieru-bbb7a712a",
        "LinkedIn profile"
    )
)