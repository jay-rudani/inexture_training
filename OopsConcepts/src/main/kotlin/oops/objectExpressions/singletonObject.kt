package oops.objectExpressions

object SharingWidget {
    private var twitterLikes = 0
    private var instagramLikes = 0

    fun increaseTwitterLikes() = twitterLikes++
    fun increaseInstagramLikes() = instagramLikes++

    fun printLikes() {
        println("Twitter Like -- $twitterLikes \nInstagram Likes -- $instagramLikes")
    }
}

fun main() {
    SharingWidget.increaseInstagramLikes()
    SharingWidget.increaseTwitterLikes()
    SharingWidget.increaseTwitterLikes()
    SharingWidget.printLikes()
}