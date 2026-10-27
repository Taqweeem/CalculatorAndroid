package com.example.myapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class ButtonFragment extends Fragment {

    String input="";
    double first=0;
    String operator="";

    public ButtonFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout
        View view = inflater.inflate(R.layout.fragment_button, container, false);
        attachListeners(view);
        return view;
    }

    private void attachListeners(View view) {
        if (view instanceof Button) {
            view.setOnClickListener(btnClick);
        } else if (view instanceof ViewGroup) {
            ViewGroup group = (ViewGroup) view;
            for (int i = 0; i < group.getChildCount(); i++) {
                attachListeners(group.getChildAt(i));
            }
        }
    }

    View.OnClickListener btnClick = v -> {
        Button b = (Button) v;
        String text = b.getText().toString();
        CalculatorActivity activity = (CalculatorActivity) getActivity();

        if (activity == null) return;

        if (text.matches("[0-9]")) {
            input += text;
            activity.UpdateResult(input);
        }
        else if (text.matches("[+\\-*/]")) {
            if (!input.isEmpty()) {
                first = Double.parseDouble(input);
                operator = text;
                input = "";
            }
        }
        else if (text.equals("=")) {

            if (!input.isEmpty() && !operator.isEmpty()) {
                double second = Double.parseDouble(input);
                double result = 0;
                switch (operator) {
                    case "+": result = first + second; break;
                    case "-": result = first - second; break;
                    case "*": result = first * second; break;
                    case "/":
                        if (second != 0) result = first / second;
                        else {
                            activity.UpdateResult("Error");
                            input = "";
                            return;
                        }
                        break;
                }
                input = String.valueOf(result);
                activity.UpdateResult(input);
            }
        }
        else if (text.equals("C")) {
            input = "";
            first = 0;
            operator = "";
            activity.UpdateResult("0");
        }
    };

    /*
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ViewGroup grid = (ViewGroup) inflater.inflate(R.layout.fragment_button, container, false);

        for(int i=0;i<grid.getChildCount();i++){
           View child=grid.getChildAt(i);
           if(child instanceof Button){
               child.setOnClickListener(btnClick);
           }
    }
       return grid;
    }
*/

    View.OnClickListener btnClicked=v->{

        Button b=(Button) v;
        String text=b.getText().toString();
        CalculatorActivity activity=(CalculatorActivity) getActivity();
        if(text.matches("[0-9]")) {
            input += text;
            activity.UpdateResult(input);
        }
        else if(text.matches("[+\\-*/]")){
            first=Double.parseDouble(input);
            operator=text;
            input="";
        }
        else if(text.equals("=")){
            double second=Double.parseDouble(input);
            double result=0;
            switch (operator){
                case "+":result=first+second;break;
                case "-":result=first-second;break;
                case "*":result=first*second;break;
                case "/":result=first/second;break;
            }
            input=String.valueOf(result);
            activity.UpdateResult(input);
            input="";
        }
        else if (text.equals("C")) {
            input="";
            first=0;
            operator="";
            activity.UpdateResult("0");
        }
    };

}
