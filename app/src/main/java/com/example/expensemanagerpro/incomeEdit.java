package com.example.expensemanagerpro;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class incomeEdit extends AppCompatActivity {

    TextInputEditText et_name,et_amount,et_category,et_note;
    ProgressDialog progressDialog;
    Button saveIncomebtn;

    //API

    ApiInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_income_edit);

        //hooks
        et_name= findViewById(R.id.nameData);
        et_amount= findViewById(R.id.amountData);
        et_category= findViewById(R.id.categoryData);
        et_note= findViewById(R.id.noteData);
        saveIncomebtn = findViewById(R.id.saveIncome);



        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Please Wait....");


        saveIncomebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = et_name.getText().toString().trim();
                String strAmount = et_amount.getText().toString().trim();
                int amount = Integer.parseInt(strAmount);
                String category = et_category.getText().toString().trim();
                String note = et_note.getText().toString().trim();
                int color = -218470;

                if (name.isEmpty()){
                    et_name.setError("Please enter name");
                }else if(strAmount.isEmpty()){
                    et_amount.setError("Please Enter amount");

                } else if (category.isEmpty()){
                    et_category.setError("Please enter category");
                }else if (note.isEmpty()){
                    et_note.setError("Please enter note");
                }else{

                    saveIncome(name,amount,category,note,color);

                }

            }
        });
    }

   /* @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.income_editor, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.saveIncome:
                //Save
                String name = et_name.getText().toString().trim();
                String strAmount = et_amount.getText().toString().trim();
                int amount = Integer.parseInt(strAmount);
                String category = et_category.getText().toString().trim();
                String note = et_note.getText().toString().trim();
                int color = -218470;

                if (name.isEmpty()){
                    et_name.setError("Please enter name");
                } else if (category.isEmpty()){
                    et_category.setError("Please enter category");
                }else if (note.isEmpty()){
                    et_note.setError("Please enter note");
                }else{

                saveIncome(name,amount,category,note,color);
                }
                return true;
            default:

                return super.onOptionsItemSelected(item);

        }
    }*/

    private void saveIncome(final String name, final int amount, final String category, final String note, final  int color)
    {
        progressDialog.show();

        apiInterface = apiClient.getApiClient().create(ApiInterface.class);
        Call<Income> call = apiInterface.saveIncome(name, amount, category, note, color);

        call.enqueue(new Callback<Income>() {
            @Override
            public void onResponse(@NonNull Call<Income> call, @NonNull Response<Income> response) {
                progressDialog.dismiss();
                if (response.isSuccessful() && response.body() !=null){
                    Boolean success = response.body().isSuccess();
                    if (success){
                        Toast.makeText(incomeEdit.this,
                                response.body().getMessage(),
                                Toast.LENGTH_SHORT).show();
                        finish(); //back to main activity
                    } else {
                        Toast.makeText(incomeEdit.this,
                                response.body().getMessage(),
                                Toast.LENGTH_SHORT).show();
                        //if error, still in this act
                    }
                }

            }

            @Override
            public void onFailure(@NonNull Call<Income> call, @NonNull Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(incomeEdit.this,
                        t.getLocalizedMessage(),
                        Toast.LENGTH_SHORT).show();

            }
        });

    }

}