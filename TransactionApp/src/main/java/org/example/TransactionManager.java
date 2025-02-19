package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.Function;
import java.util.function.Consumer;

public class TransactionManager {
    private List<Transaction> transactions = new ArrayList<>();


    public void addTransaction(Transaction t) {
        transactions.add(t);
    }

    public List<Transaction> filterTransactions(Predicate<Transaction> predicate) {
        List<Transaction> result = new ArrayList<>();
        for (Transaction t : transactions) {
            if (predicate.test(t)) {        //전달받은 람다식을 test에 오버라이드 하여 조건에 따라 true 또는 false 리턴.
                result.add(t);
            }
        }
        return result;
    }

    // Function: 트랜잭션 금액 변환(매핑)
    public List<Double> mapAmounts(Function<Transaction, Double> function) {
        List<Double> result = new ArrayList<>();
        for (Transaction t : transactions) {
            result.add(function.apply(t));
        }
        return result;
    }

    // Consumer: 트랜잭션 처리(출력, 로깅 등)
    public void processTransactions(Consumer<Transaction> consumer) {
        for (Transaction t : transactions) {
            consumer.accept(t);
        }
    }
}
