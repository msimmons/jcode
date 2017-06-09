package net.contrapt.jcode.controller

import javafx.beans.property.ReadOnlyIntegerWrapper
import javafx.beans.property.ReadOnlyObjectWrapper
import javafx.beans.property.SimpleBooleanProperty
import javafx.scene.control.Control
import net.contrapt.jcode.model.EditorContent

/**
 * Created by mark on 6/9/17.
 */
class EditorControl(val content: EditorContent) : Control() {

    /** The number of characters */
    val lengthProperty = ReadOnlyIntegerWrapper(this, "length", content.length())
    val length : Int
        get() = lengthProperty.get()

    /** Whether the content is editable by the user */
    val editableProperty = SimpleBooleanProperty(this, "editable", true)
    var editable : Boolean
       get() = editableProperty.get()
       set(x) {editableProperty.value = x}

    /** The current selection ranges ?? Rectangular */
    val selectionsProperty = ReadOnlyObjectWrapper<Collection<IntRange>>(this, "selections", listOf())
    val selections
       get() = selectionsProperty.get()

    /** The current caret position */
    val caretPositionProperty = ReadOnlyIntegerWrapper(this, "caretPosition", 0)
    val caretPosition : Int
        get() = caretPositionProperty.get()


}