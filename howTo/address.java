public String convertAdderssFromLocation(Location location){
    // it will work with Latlng class. or Latitude/Longitude (double) variable. 

    Geocoder geocoder = new Geocoder(getApplicationContext(), Locale.getDefault());
    String address = "Address: ";
    try {
        List<Address> addressList = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(), 1);
        // @perams: latitude, longitude
        //        : 1 (how many result we want)
        for (int i = 0; i <= addressList.get(0).getMaxAddressLineIndex(); i++) {
            address += addressList.get(0).getAddressLine(i) + ", ";
        }
        if (addressList.get(0).getPostalCode() != null && !addressList.get(0).getPostalCode().equals("")){
            address += addressList.get(0).getPostalCode();
        }
        addressView.setText(address);
        return address;
    } catch (IOException e) {
        e.printStackTrace();
    } catch (Exception e){
        e.printStackTrace();
    }
    return "no address found"
}