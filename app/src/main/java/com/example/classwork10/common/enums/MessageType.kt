package com.example.classwork10.common.enums

import com.example.classwork10.R

enum class MessageType {
    TEXT{
        override val icon: Int
            get() = R.drawable.ic_baseline_circle_24

    },
    ATTACHMENT {
        override val icon: Int
            get() = R.drawable.ic_baseline_attachment_24

        override fun toString() = "Sent an attachment"
    },
    VOICE {
        override val icon: Int
            get() = R.drawable.ic_baseline_keyboard_voice_24
        override fun toString() = "Sent a voice message"
    },
    DEFAULT {
        override val icon: Int
            get() = R.drawable.ic_baseline_circle_24
    };

    abstract val icon: Int
    companion object {
        fun stringToType(type: String): MessageType = when (type) {
            "text" -> TEXT
            "attachment" -> ATTACHMENT
            "voice" -> VOICE
            else -> DEFAULT
        }
    }
}