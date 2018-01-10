/*********** check SDK virsion *******************/
        int apiLevel = Build.VERSION.SDK_INT;
        if (apiLevel >= Build.VERSION_CODES.M){
            Toast.makeText(this, "android higher M", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this, "android below M", Toast.LENGTH_SHORT).show();
        }



/*********** check Screen size *******************/
 int screenSize = getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK;

        switch (screenSize){
            case Configuration.SCREENLAYOUT_SIZE_NORMAL:
                Toast.makeText(this, "normal size screen", Toast.LENGTH_SHORT).show();
                break;
            case Configuration.SCREENLAYOUT_SIZE_LARGE:
                Toast.makeText(this, "large size screen", Toast.LENGTH_SHORT).show();
                break;
            case Configuration.SCREENLAYOUT_SIZE_XLARGE:
                Toast.makeText(this, "eXtralearge size screen", Toast.LENGTH_SHORT).show();
                break;
        }