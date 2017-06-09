package net.contrapt.jcode.model

import javafx.beans.InvalidationListener
import javafx.beans.value.ChangeListener
import javafx.beans.value.ObservableStringValue

/**
 * Created by mark on 6/9/17.
 */
class EditorContent(var content: String) : ObservableStringValue {
    override fun removeListener(listener: ChangeListener<in String>?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun removeListener(listener: InvalidationListener?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun addListener(listener: InvalidationListener?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun addListener(listener: ChangeListener<in String>?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getValue(): String {
        return content
    }

    override fun get(): String {
        return content
    }

    /**
     * Retrieves a subset of the content.
     * @param start
     * @param end
     */
    fun get(start: Int, end: Int): String {
        return content.substring(start..end)
    }

    /**
     * Inserts a sequence of characters into the content.

     * @param index
     * *
     * @param text
     * *
     * @since JavaFX 2.1
     */
    fun insert(index: Int, text: String, notifyListeners: Boolean) {
        println("Inserting $text at $index")
    }

    /**
     * Removes a sequence of characters from the content.

     * @param start
     * *
     * @param end
     * *
     * @since JavaFX 2.1
     */
    fun delete(start: Int, end: Int, notifyListeners: Boolean) {
        println("Deleting from $start to $end")
    }

    /**
     * Returns the number of characters represented by the content.
     */
    fun length(): Int {
        return content.length
    }
}