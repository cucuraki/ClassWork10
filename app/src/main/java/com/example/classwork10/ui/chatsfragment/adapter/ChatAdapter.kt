package com.example.classwork10.ui.chatsfragment.adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.*
import com.example.classwork10.common.enums.MessageType
import com.example.classwork10.common.extensions.load
import com.example.classwork10.databinding.ChatItemBinding
import com.example.classwork10.databinding.FragmentChatsBinding
import com.example.classwork10.domain.models.ChatModel
import java.text.SimpleDateFormat
import java.util.*

class ChatAdapter : ListAdapter<ChatModel, ChatAdapter.ChatViewHolder>(ChatDiffUtil()) {

    inner class ChatViewHolder(private val binding: ChatItemBinding) : ViewHolder(binding.root) {
        fun onBind(position: Int){
            val model = getItem(position)
            with(model) {
                binding.icon.load(avatar)
                binding.tittle.text = "$firstName $lastName"
                if(messageType == MessageType.TEXT){
                    binding.typeIcon.visibility = GONE
                    binding.lastMessage.text = lastMessage?:""
                }else{
                    binding.typeIcon.visibility = VISIBLE
                    binding.typeIcon.setBackgroundResource(messageType.icon)
                    binding.lastMessage.text = messageType.toString()
                }
                if(isTyping){
                    binding.writes.visibility = VISIBLE
                    binding.unread.visibility = GONE
                }
                else if(unreadMessage!=0){
                    binding.writes.visibility = GONE
                    binding.unread.visibility = VISIBLE
                    binding.unread.text = unreadMessage.toString()
                }
                else{
                    binding.writes.visibility = GONE
                    binding.unread.visibility = GONE
                }
                binding.time.text = getData(updatedData, "hh:mm a")
            }
        }
    }
    private fun getData(milliSeconds: Long, dateFormat: String?): String?{
        val formatter = SimpleDateFormat(dateFormat)
        val calendar = Calendar.getInstance()
        calendar.timeInMillis = milliSeconds
        return formatter.format(calendar.time)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ChatViewHolder(ChatItemBinding.inflate(LayoutInflater.from(parent.context)))

    override fun onBindViewHolder(holder: ChatViewHolder, position: Int) {
        holder.onBind(position)
    }
}

class ChatDiffUtil() : DiffUtil.ItemCallback<ChatModel>() {
    override fun areItemsTheSame(oldItem: ChatModel, newItem: ChatModel) = oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: ChatModel, newItem: ChatModel) = oldItem == newItem

}