package net.contrapt.jcode

import com.sun.javafx.webkit.Accessor
import javafx.application.Application
import javafx.collections.FXCollections
import javafx.concurrent.Worker
import javafx.geometry.Insets
import javafx.scene.Scene
import javafx.scene.control.*
import javafx.scene.layout.GridPane
import javafx.scene.shape.Box
import javafx.scene.text.Text
import javafx.scene.text.TextFlow
import javafx.scene.web.WebView
import javafx.stage.Stage

/**
 * Created by mark on 6/9/17.
 */
class JCode : Application() {

    override fun start(primaryStage: Stage) {
        primaryStage.title = "My FX Application"
        val grid = GridPane().apply {
            //alignment = Pos.BASELINE_CENTER
            hgap = 10.0
            vgap = 10.0
            padding = Insets(25.0, 25.0, 25.0, 25.0)
            isGridLinesVisible = true
        }
        val m1 = MenuBar(Menu("Hello", Box(), MenuItem("one")))
        val tb2 = ToolBar(Button("Click"), CheckBox("Box"))
        val ta = TextArea()
        val tp = SplitPane(TabPane(Tab("one"), Tab("two")), ta).apply {
            setDividerPosition(0, 0.2)
        }
        grid.add(m1, 0, 0, 2, 1)
        grid.add(tp, 0, 1)
        grid.add(tb2, 0, 2, 2, 1)
        val tf1 = TextFlow(Text("A line of Some text\n"))
        val tf2 = TextFlow(Text("Another line"), Text("And some more"), Text("\n"))

        val flowList = FXCollections.observableArrayList<TextFlow>(mutableListOf<TextFlow>(tf1, tf2))
        val listView = ListView<TextFlow>(flowList).apply {
            isEditable = true
        }

        val webView = WebView().apply {
            val css = JCode::class.java.getResource("/com/cinchfinancial/kool/myfx.css").toString()
            val html = JCode::class.java.getResource("/com/cinchfinancial/kool/myfx.html")
            engine.userStyleSheetLocation = css
            //engine.load(html.toString())
            engine.loadContent("<html><head></head><body contenteditable=\"true\"><span>Some <span class=\"keyword\">text</span></span></body></html>")
        }
        webView.engine.getLoadWorker().stateProperty().addListener({ obs, oldState, newState ->
            if (newState == Worker.State.SUCCEEDED) {
                val doc = webView.engine.getDocument()
                (0..doc.childNodes.length-1).forEach {
                    println("position ${doc.childNodes.item(it).compareDocumentPosition(doc)}")
                    println(doc.childNodes.item(it).lastChild.firstChild)
                }
            }
        })
        val webPage = Accessor.getPageFor(webView.engine)
        listView.setOnMouseClicked { println("Mouse clicked");flowList.remove(0,1) }
        webView.setOnMouseClicked {
            println("Mouse")
            println(webPage.clientInsertPositionOffset)
        }
        val scene = Scene(webView, -1.0, -1.0)
        primaryStage.scene = scene
        primaryStage.show()
    }

    companion object {

        @JvmStatic
        fun main(vararg args : String) {
            launch(JCode::class.java, *args)
        }
    }
}