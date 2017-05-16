package jp.ac.chiba_fjb.x15g009.fragmenttest;


import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class BlankFragment extends DialogFragment implements View.OnClickListener{

    public BlankFragment() {

    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialog = super.onCreateDialog(savedInstanceState);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        return dialog;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_blank, container, false);
        view.findViewById(R.id.button1).setOnClickListener(this);
        view.findViewById(R.id.button2).setOnClickListener(this);
        view.findViewById(R.id.button3).setOnClickListener(this);
        view.findViewById(R.id.button4).setOnClickListener(this);
        return view;
    }

    //インタフェイスの定義
    public interface OnDialogButtonListener{
        void onDialogButton(int value);
    }
    //インタフェイスのインスタンス保存用
    OnDialogButtonListener mListener;

    //ボタン動作のインスタンスを受け取る
    public void setOnDialogButtonListener(OnDialogButtonListener listener){
        mListener =  listener;
    }

    @Override
    public void onClick(View v) {
        if(mListener != null) {
            if (v.getId() == R.id.button1)
                mListener.onDialogButton(0);
            else if (v.getId() == R.id.button2)
                mListener.onDialogButton(1);
            else if (v.getId() == R.id.button3)
                mListener.onDialogButton(2);
            else if (v.getId() == R.id.button4)
                mListener.onDialogButton(3);
        }
        //ダイアログを閉じる
        getDialog().cancel();
    }
}
