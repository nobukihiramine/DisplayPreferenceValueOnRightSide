package com.hiramine.displaypreferencevalueonrightside;

import android.content.Context;
import android.preference.EditTextPreference;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class EditTextPreferenceDisplayValue extends EditTextPreference
{
	public EditTextPreferenceDisplayValue( Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes )
	{
		super( context, attrs, defStyleAttr, defStyleRes );
	}

	public EditTextPreferenceDisplayValue( Context context, AttributeSet attrs, int defStyleAttr )
	{
		super( context, attrs, defStyleAttr );
	}

	public EditTextPreferenceDisplayValue( Context context, AttributeSet attrs )
	{
		super( context, attrs );
	}

	public EditTextPreferenceDisplayValue( Context context )
	{
		super( context );
	}

	@Override
	protected View onCreateView( ViewGroup parent )
	{
		setWidgetLayoutResource( R.layout.widget_valuetext );
		return super.onCreateView( parent );
	}

	@Override
	protected void onBindView( View view )
	{
		super.onBindView( view );
		TextView textView = (TextView)view.findViewById( R.id.textview_value );
		textView.setText( getText() );
	}
}
