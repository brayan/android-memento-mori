package br.com.sailboat.mementomori.domain.repository

interface YearOfDeathRepository {
    fun add(year: Int)
    fun remove()
    fun get(): Int
    fun contains(): Boolean
}