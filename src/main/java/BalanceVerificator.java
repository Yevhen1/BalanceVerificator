import java.util.LinkedList;

public class BalanceVerificator {

    public int bracketsBalance(String bracket){
        if (bracket.isEmpty()){
            System.out.println("Input is empty: ");
            return 0;
        }

        char[] bracketArr = bracket.toCharArray();
        String brackets = "(){}[]";
        for (char character : bracketArr){
            if (brackets.indexOf(character) == -1){
                System.out.println("The string contains ‘" + character +
                        "’ character that doesn’t belong to bracket types ([{ or }])");
                throw new IllegalArgumentException();
            }
        }

        LinkedList<Character> bracketList = new LinkedList<Character>();
        for (int bracketCount = 0; bracketCount < bracketArr.length; bracketCount++){
            if (bracketArr[bracketCount] == '(' || bracketArr[bracketCount] == '{' || bracketArr[bracketCount] == '['){
                bracketList.add(bracketArr[bracketCount]);
            }
            switch (bracketArr[bracketCount]){
                case ')':
                    if (bracketList.getLast() == '('){
                        bracketList.removeLast();
                    }else {
                        System.out.println("NOT BALANCED");
                        return ++bracketCount;
                    }
                    break;
                case '}':
                    if (bracketList.getLast() == '{'){
                        bracketList.removeLast();
                    }else {
                        System.out.println("NOT BALANCED");
                        return ++bracketCount;
                    }
                    break;
                case ']':
                    if (bracketList.getLast() == '['){
                        bracketList.removeLast();
                    }else {
                        System.out.println("NOT BALANCED");
                        return ++bracketCount;
                    }
                    break;
            }
        }
        System.out.println("BALANCED");
        return -1;
    }
}
