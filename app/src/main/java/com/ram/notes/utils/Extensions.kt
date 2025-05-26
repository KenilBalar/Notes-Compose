package com.ram.notes.utils

import android.content.Context
import android.widget.Toast

/**
 * @author ASUS
 * @date 26-05-2025
 */

fun Context.toast(content: String){
    Toast.makeText(this, content.trim(), Toast.LENGTH_SHORT).show()
}