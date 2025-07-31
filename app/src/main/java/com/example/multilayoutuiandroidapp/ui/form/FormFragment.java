package com.example.multilayoutuiandroidapp.ui.form;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.multilayoutuiandroidapp.R;
import com.example.multilayoutuiandroidapp.data.DatabaseHelper;

public class FormFragment extends Fragment {
    private EditText editTextName;
    private EditText editTextEmail;
    private EditText editTextPhone;
    private DatabaseHelper databaseHelper;

    public View onCreateView(@NonNull LayoutInflater inflater,
                           ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_constraint, container, false);

        databaseHelper = new DatabaseHelper(requireContext());
        editTextName = root.findViewById(R.id.editTextFormName);
        editTextEmail = root.findViewById(R.id.editTextFormEmail);
        editTextPhone = root.findViewById(R.id.editTextFormPhone);

        Button buttonSubmit = root.findViewById(R.id.buttonSubmit);
        Button buttonClear = root.findViewById(R.id.buttonClear);

        buttonSubmit.setOnClickListener(v -> submitForm());
        buttonClear.setOnClickListener(v -> clearForm());

        return root;
    }

    private void submitForm() {
        String name = editTextName.getText().toString();
        String email = editTextEmail.getText().toString();
        String phone = editTextPhone.getText().toString();

        if (name.isEmpty() || email.isEmpty() || phone.isEmpty()) {
            Toast.makeText(requireContext(), "Please fill all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        long result = databaseHelper.insertStudent(name, email, phone);
        if (result != -1) {
            Toast.makeText(requireContext(), "Data saved successfully", Toast.LENGTH_SHORT).show();
            clearForm();
        } else {
            Toast.makeText(requireContext(), "Error saving data", Toast.LENGTH_SHORT).show();
        }
    }

    private void clearForm() {
        editTextName.setText("");
        editTextEmail.setText("");
        editTextPhone.setText("");
    }
}
