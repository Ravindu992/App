package com.example.multilayoutuiandroidapp.ui.Frame;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.multilayoutuiandroidapp.R;
import com.example.multilayoutuiandroidapp.databinding.FragmentFrameBinding;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class FrameFragment extends Fragment {

    private static final String PREFS_NAME = "ProfilePrefs";
    private static final String PROFILE_IMAGE_PATH = "profile_image_path";
    
    private FragmentFrameBinding binding;
    private ImageView profileImage;
    private SharedPreferences sharedPreferences;

    // Using ActivityResultLauncher instead of deprecated onActivityResult
    private final ActivityResultLauncher<Intent> imagePickerLauncher =
            registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
                if (result.getResultCode() == android.app.Activity.RESULT_OK && result.getData() != null) {
                    Uri imageUri = result.getData().getData();
                    saveImageToInternalStorage(imageUri);
                }
            });

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        FrameViewModel dashboardViewModel =
                new ViewModelProvider(this).get(FrameViewModel.class);

        binding = FragmentFrameBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textFrame;
        dashboardViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);

        profileImage = binding.profileImage;
        Button editButton = binding.btnEditProfile;

        // Initialize SharedPreferences
        sharedPreferences = requireContext().getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);

        // Load saved image if exists
        loadSavedImage();

        editButton.setOnClickListener(v -> openGallery());

        return root;
    }

    private void openGallery() {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        intent.setType("image/*");
        imagePickerLauncher.launch(intent);
    }

    private void saveImageToInternalStorage(Uri imageUri) {
        try {
            // Create a file in the app's internal storage
            File imageFile = new File(requireContext().getFilesDir(), "profile_image.jpg");
            
            // Copy the selected image to internal storage
            InputStream inputStream = requireContext().getContentResolver().openInputStream(imageUri);
            FileOutputStream outputStream = new FileOutputStream(imageFile);
            
            byte[] buffer = new byte[1024];
            int length;
            while ((length = inputStream.read(buffer)) > 0) {
                outputStream.write(buffer, 0, length);
            }
            
            inputStream.close();
            outputStream.close();

            // Save the file path in SharedPreferences
            sharedPreferences.edit()
                    .putString(PROFILE_IMAGE_PATH, imageFile.getAbsolutePath())
                    .apply();

            // Load the saved image
            loadSavedImage();
            
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(requireContext(), "Error saving image", Toast.LENGTH_SHORT).show();
        }
    }

    private void loadSavedImage() {
        String imagePath = sharedPreferences.getString(PROFILE_IMAGE_PATH, null);
        if (imagePath != null) {
            File imageFile = new File(imagePath);
            if (imageFile.exists()) {
                // Load and set the image
                Bitmap bitmap = BitmapFactory.decodeFile(imagePath);
                profileImage.setImageBitmap(bitmap);
            }
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
