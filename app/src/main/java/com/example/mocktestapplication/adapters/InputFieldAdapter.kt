package com.example.mocktestapplication.adapters

import android.text.InputType
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mocktestapplication.R
import com.example.mocktestapplication.ui.LoginActivity
import com.google.android.material.textfield.TextInputEditText
import kotlinx.android.synthetic.main.input_field_item.view.*

class InputFieldAdapter(private val listener: LoginActivity) : RecyclerView.Adapter<InputFieldAdapter.InputFieldViewHolder>() {

    private var inputFieldList = mutableListOf<String>()
    private  var textOfField = arrayListOf<String>("", "")

    private var inputHolder = arrayListOf<InputFieldViewHolder>()

    fun setInputFields(field : List<String>){
        this.inputFieldList = field.toMutableList()
        notifyDataSetChanged()
    }

    fun getInputFields() : ArrayList<String> {
        return textOfField
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InputFieldViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.input_field_item, parent, false)
        return InputFieldViewHolder(view)
    }

    override fun onBindViewHolder(holder: InputFieldViewHolder, position: Int) {
        holder.inputFieldName.hint = inputFieldList[position]
        if(holder.inputFieldName.hint.toString() != "Password") {
            holder.inputFieldName.inputType = InputType.TYPE_CLASS_TEXT
        }

        inputHolder.add(holder)
    }

    fun getTextFields(){
        for (i in 0 until inputHolder.size){
            textOfField[i]  = inputHolder[i].inputFieldName.text.toString()
        }
    }

    override fun getItemCount(): Int {
        return inputFieldList.size
    }

    inner class InputFieldViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val inputFieldName: TextInputEditText = itemView.input_field
    }

}