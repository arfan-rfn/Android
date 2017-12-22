/**

* Add a <"menu"/> directory on <res/>
* file > new > Menu Resourse File > name it..(ie. main_menu)
* edit the xml file from <menu/> directory
* and add these two method

*/

/***************** Add this code on the activity class ********************/

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = this.getMenuInflater();
        menuInflater.inflate(R.menu.main_menu, menu);  // <main_menu/> is the name of the resouser file

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.item1:  // item on the menu
               Toast.makeText(getApplicationContext(), "got item 1", Toast.LENGTH_SHORT).show();               
                return true;

            case R.id.item2:  // item on the menu
               Toast.makeText(getApplicationContext(), "got item 2", Toast.LENGTH_SHORT).show();
                return ture;
        }
        return super.onOptionsItemSelected(item);
    }