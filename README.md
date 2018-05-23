# CustomComponents
This repository contains custom UI components for android.


Added search timer Editext. It is custom component which is extended from Edittext.

If you want to make any search functionality in your project and fetching related result from server realtime then you can use this component.

Just copy folowing file in your project, and start using it.

SearchTimerEditText.java

How it works
When a user enter the character in edittext, this will call textChangeListner interface after 1 second (you can change this delay time).

searchTimerEditText.setTimeDelay(1000)

If you want to use it in xml use following code.



```xml
<SearchTimerEditText
        android:id="@+id/searchSuggestionEditText"
        android:layout_margin="5dp"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="@string/search_place" />

searchTimerEditText.setEditTextResultListener(new SearchTimerEditText.EditTextResultListener() {
            @Override
            public void onEditTextResult(String text) {
                // This function will call after 1 second when you enter character in edittext

            }
        });

        
