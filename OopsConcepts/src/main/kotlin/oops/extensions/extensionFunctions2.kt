package oops.extensions

// you can declare extensions for one class inside another class
// an instance of a class in which the extension is declared is called dispatch receiver
// an instance of the receiver type of the extension method is called extension receiver

class Host(val hostname: String) {
    fun printHostname() {
        print(hostname)
    }
}

class Connection(val host: Host, val port: Int) {
    fun printPort() {
        print(port)
    }

    fun Host.printConnectionString() {
        printHostname() // calls Host.printHostname()
        print(":")
        printPort() // calls Connection.printPort()
    }

    fun connect() {
        host.printConnectionString() // calls extension function
    }
}

fun main() {
    Connection(Host("localhost"), 8080).connect()
    // Host("localhost").printConnectionString() // error, extension function is unavailable outside Connection
}