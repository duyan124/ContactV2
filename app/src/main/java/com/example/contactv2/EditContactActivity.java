package com.example.contactv2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EditContactActivity extends AppCompatActivity {
    EditText edtNameEdit,edtMobileEdit;
    Button btnCancel,btnFinish;
    Contact contact;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_contact);

        edtNameEdit = (EditText) findViewById(R.id.edt_nameedit);
        edtMobileEdit = (EditText) findViewById(R.id.edt_mobileedit);
        btnCancel = (Button) findViewById(R.id.btn_cancel);
        btnFinish = (Button) findViewById(R.id.btn_finish);

        Bundle bundle = getIntent().getBundleExtra("editsend");
        contact = (Contact) bundle.getSerializable("edit");

        edtNameEdit.setText(contact.getName());
        edtMobileEdit.setText(contact.getPhone());

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = edtNameEdit.getText().toString();
                String phone = edtMobileEdit.getText().toString();
                if (name.length()==0)
                {
                    Toast.makeText(EditContactActivity.this,"Insert Name",Toast.LENGTH_SHORT).show();
                }
                else if (phone.length()==0)
                {
                    Toast.makeText(EditContactActivity.this,"Insert Phone Number",Toast.LENGTH_SHORT).show();
                }
                else {
                    contact.setName(name);
                    contact.setPhone(phone);

                    Bundle bundle = new Bundle();
                    bundle.putSerializable("editback", contact);

                    Intent resultIntent = getIntent();
                    resultIntent.putExtra("edited", bundle);
                    setResult(Activity.RESULT_OK, resultIntent);
                    finish();
                }
            }
        });
    }
}
