/************************* upload image to Parse server *****************************/
                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream); // compress image
                byte[] byteArray = stream.toByteArray();  // convert into byte array
                ParseFile file = new ParseFile("image.png", byteArray);  // <image.png/> name of the picture
                ParseObject object = new ParseObject("Image");
                object.put("image", file);  // upload the file
                object.put("username", ParseUser.getCurrentUser().getUsername());  // and username
                object.saveInBackground(new SaveCallback() {  // save the shit
                    @Override
                    public void done(ParseException e) {
                        if (e == null){
                            Toast.makeText(SecondActivity.this, "image Shared", Toast.LENGTH_SHORT).show();
                        }else {
                            Toast.makeText(SecondActivity.this, "Image unable to Shate, please try again later", Toast.LENGTH_SHORT).show();
                        }
                    }
                });