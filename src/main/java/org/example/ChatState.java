package org.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ChatState {

    public String state;
    public String data = null;
    public Map<String, List<Integer>> expenses = new HashMap<>();


    public ChatState(String initialState) {
        state = initialState;
    }

    public String getFormattedCategories(){
        Set<String> categories = expenses.keySet();
        if (categories.isEmpty()) return "Категории отсутсвуют";
        return String.join("\n", categories);
    }

    public String getFormattedExpenses(){
        if (expenses.isEmpty()) return "Категории отсутсвуют";
        String formattedResult = "";
        for (var category : expenses.entrySet()){
            String categoryName = category.getKey();
            List<Integer> categoryExpenses = category.getValue();
            formattedResult += categoryName + ": " + getFormattedExpenses(categoryExpenses) + "\n";
        }
        return formattedResult;
    }

    private String getFormattedExpenses(List<Integer> expensesPerCategory){
        String formattedResult = "";
        for (Integer expense : expensesPerCategory){
            formattedResult += expense + " ";
        }
        return formattedResult;
    }
}
