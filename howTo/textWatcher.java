 
String userInput = "";
 editTextBox.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                userInput = String.valueOf(s);
                // do whatever you wanna do with this string
            }

            @Override
            public void afterTextChanged(Editable s) {

            }

        });