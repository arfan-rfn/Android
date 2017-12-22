ArrayList<String> arrayList = new ArrayList<>();
arrayList.add("name");
arrayList.add("name2");
arrayList.add("name3");



ListView listView = findViewById(R.id.listView);
ArrayAdapter arrayAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, notes);
listView.setAdapter(arrayAdapter);

listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(MainActivity.this, arrayList.get(position), Toast.LENGTH_SHORT).show();
        }
});