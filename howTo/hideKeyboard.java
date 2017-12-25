InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);