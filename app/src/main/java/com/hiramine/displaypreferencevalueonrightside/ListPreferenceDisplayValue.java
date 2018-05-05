package com.hiramine.displaypreferencevalueonrightside;

import android.content.Context;
import android.preference.ListPreference;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ListPreferenceDisplayValue extends ListPreference
{
	public ListPreferenceDisplayValue( Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes )
	{
		super( context, attrs, defStyleAttr, defStyleRes );
	}

	public ListPreferenceDisplayValue( Context context, AttributeSet attrs, int defStyleAttr )
	{
		super( context, attrs, defStyleAttr );
	}

	public ListPreferenceDisplayValue( Context context, AttributeSet attrs )
	{
		super( context, attrs );
	}

	public ListPreferenceDisplayValue( Context context )
	{
		super( context );
	}

	@Override
	protected View onCreateView( ViewGroup parent )
	{
		setWidgetLayoutResource( R.layout.widget_preferencevalue );
		return super.onCreateView( parent );
	}

	@Override
	protected void onBindView( View view )
	{
		super.onBindView( view );
		TextView textView = (TextView)view.findViewById( R.id.textview_preferencevalue );

		textView.setText( getEntry() );
	}
}
