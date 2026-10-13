package org.familysafety.child

import android.app.Activity
import android.os.Bundle
import android.graphics.Color
import android.graphics.Typeface
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.TextView

/** Child companion setup starter; code entry is local demo only until backend pairing is implemented. */
class MainActivity : Activity() {
    private lateinit var status: TextView
    private lateinit var codeInput: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val pad = (resources.displayMetrics.density * 20).toInt()
        val content = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(pad, pad, pad, pad)
            setBackgroundColor(Color.rgb(247, 249, 252))
        }
        content.addView(TextView(this).apply {
            text = "Family Safety Child"
            textSize = 26f
            typeface = Typeface.DEFAULT_BOLD
            setTextColor(Color.rgb(15, 80, 70))
        })
        content.addView(TextView(this).apply {
            text = "Enter the pairing code shown in the parent's app. This demo does not send it to a server."
            textSize = 15f
            setTextColor(Color.DKGRAY)
            setPadding(0, pad / 3, 0, pad)
        })
        codeInput = EditText(this).apply {
            hint = "Pairing code"
            singleLine = true
            inputType = android.text.InputType.TYPE_CLASS_TEXT or android.text.InputType.TYPE_TEXT_FLAG_CAP_CHARACTERS
        }
        content.addView(codeInput)
        status = TextView(this).apply {
            text = "Status: not connected"
            textSize = 16f
            setTextColor(Color.rgb(30, 70, 55))
            setPadding(0, pad / 2, 0, pad / 2)
        }
        content.addView(status)
        content.addView(Button(this).apply {
            text = "Validate code format"
            isAllCaps = false
            setOnClickListener {
                val code = codeInput.text.toString().trim().uppercase()
                status.text = if (code.matches(Regex("[23456789ABCDEFGHJKLMNPQRSTUVWXYZ]{6,12}"))) {
                    "Code format valid. Device is still not paired; server verification is not implemented."
                } else {
                    "Enter a 6–12 character code using the characters shown by the parent app."
                }
            }
        }, LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT))
        content.addView(TextView(this).apply {
            text = "\nPrivacy\nNo location, microphone, camera, call logs, contacts, or messages are accessed by this starter. When real features are added, the app will explain permissions and show active protection status."
            textSize = 14f
            setTextColor(Color.DKGRAY)
        })
        setContentView(ScrollView(this).apply { addView(content) })
    }
}
