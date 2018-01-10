// add any view programatically 

ImageView imageView = new ImageView(getApplicationContext());
imageView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
imageView.setImageDrawable(getResources().getDrawable(R.drawable.insta));