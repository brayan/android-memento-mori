package br.com.sailboat.mementomori.domain

@SuppressWarnings
abstract class UseCase<out Type> where Type : Any {
    abstract fun execute(): Type
    operator fun invoke() = execute()
}