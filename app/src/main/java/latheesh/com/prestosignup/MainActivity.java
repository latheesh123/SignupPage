package latheesh.com.prestosignup;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText firstname, lastname, email, phonenumber;
    Button regsignup, mainsignup;
    boolean isValid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainsignup = findViewById(R.id.signup);
        mainsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClickSignup();

            }
        });
    }

    private void ClickSignup() {

        final AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.signup_page, null);
        dialog.setView(dialogView);


        firstname = dialogView.findViewById(R.id.reg_firstName);
        lastname = dialogView.findViewById(R.id.reg_lastName);
        email = dialogView.findViewById(R.id.reg_email);
        regsignup = dialogView.findViewById(R.id.reg_register);
        phonenumber = dialogView.findViewById(R.id.reg_phonenum);
        final AlertDialog alertDialog = dialog.create();

        regsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                isValid = true;
                if (firstname.getText().toString().trim().isEmpty()) {

                    firstname.setError("Please fill out this field");
                    isValid = false;
                } else if (!firstname.getText().toString().matches("[a-zA-Z]*")) {
                    firstname.setError("Please enter only alphabets");
                    isValid = false;
                }


                if (lastname.getText().toString().trim().isEmpty()) {

                    lastname.setError("Please fill out this field");
                    isValid = false;
                } else if (!lastname.getText().toString().matches("[a-zA-Z]*")) {
                    lastname.setError("Please enter only alphabets");
                    isValid = false;
                }

                if (email.getText().toString().trim().isEmpty()) {

                    email.setError("Please fill out this field");
                    isValid = false;
                }

                if (!isValidEmail(email.getText().toString())) {
                    email.setError("check the email address");
                    isValid = false;
                }
                if (!phonenumber.getText().toString().matches("[0-9]*")) {
                    phonenumber.setError("phone number should be numbers");
                    isValid = false;
                }

                if (isValid) {
                    AlertDialog successdialog = new AlertDialog.Builder(MainActivity.this).create();
                    successdialog.setTitle("Success");
                    successdialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                    alertDialog.dismiss();
                                }
                            });
                    successdialog.show();

                }

            }
        });

        alertDialog.show();


    }


    public static boolean isValidEmail(CharSequence target) {
        if (target == null) {
            return false;
        } else {
            return android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
        }
    }

}
