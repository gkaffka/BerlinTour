package com.kaffka.berlintour.domain.entity

data class Review(val id: String,
                  val rating: Float,
                  val title: String?,
                  val message: String?,
                  val author: String?,
                  val foreignLanguage: Boolean,
                  val date: String?,
                  val languageCode: String?,
                  val travelerType: String?,
                  val reviewerName: String?,
                  val reviewerCountry: String?)