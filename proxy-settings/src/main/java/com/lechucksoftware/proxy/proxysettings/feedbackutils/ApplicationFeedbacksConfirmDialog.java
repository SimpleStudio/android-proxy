package com.lechucksoftware.proxy.proxysettings.feedbackutils;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.afollestad.materialdialogs.MaterialDialog;
import com.lechucksoftware.proxy.proxysettings.R;
import com.lechucksoftware.proxy.proxysettings.ui.base.BaseDialogFragment;

public class ApplicationFeedbacksConfirmDialog extends BaseDialogFragment
{
	public ApplicationFeedbacksConfirmDialog()
	{

	}
	
    public static ApplicationFeedbacksConfirmDialog newInstance(PInfo pInfo) 
    {
    	ApplicationFeedbacksConfirmDialog frag = new ApplicationFeedbacksConfirmDialog();
        
    	Bundle args = new Bundle();
        args.putParcelable("appInfo", pInfo);
        frag.setArguments(args);  
        
        return frag;
    }
    
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) 
    {	
    	PInfo appInfo = getArguments().getParcelable("appInfo");
    	
    	View view = LayoutInflater.from(getActivity()).inflate(R.layout.feedback_submit_dialog, (ViewGroup) getActivity().findViewById(R.id.layout_root));
    	ImageView appico = (ImageView) view.findViewById(R.id.feedback_app_icon);
    	appico.setImageDrawable(appInfo.icon);
    	
    	TextView appname = (TextView) view.findViewById(R.id.feedback_app_name);
    	appname.setText(appInfo.appname);
    	
    	TextView pname = (TextView) view.findViewById(R.id.feedback_app_description);
    	pname.setText(appInfo.pname);
    	
    	TextView pvers = (TextView) view.findViewById(R.id.feedback_app_version);
    	pvers.setText(appInfo.versionName);
    	
//    	TextView dialog_accept_desc = (TextView) view.findViewById(R.id.application_dialog_accept_description);
//    	String formatdesc = getActivity().getResources().getString(R.string.application_feedback_dialog_accept_description);
//    	String fulldesc = String.format(formatdesc, appInfo.pname);
//    	dialog_accept_desc.setText(fulldesc);
    	
        MaterialDialog.Builder builder = new MaterialDialog.Builder(getActivity());
        builder.customView(view, false);
        
        builder.title(R.string.application_feedback_dialog_title);
        builder.positiveText(R.string.accept);
        builder.negativeText(R.string.cancel);
        builder.callback(new MaterialDialog.ButtonCallback() {
            @Override
            public void onPositive(MaterialDialog dialog)
            {

            }

            @Override
            public void onNegative(MaterialDialog dialog)
            {

            }
        });

    	return builder.build();
    }

}