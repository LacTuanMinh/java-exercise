package streamapi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamAPIExerciseComplex {

    private static final Logger LOGGER = LoggerFactory.getLogger(StreamAPIExerciseComplex.class);
    private static final List<Employee> EMPLOYEES = Employees.allEmployees();

    public static void main(String[] args) {
        StreamAPIExerciseComplex excercise = new StreamAPIExerciseComplex();

        LOGGER.info("{}", excercise.exercise1());
        LOGGER.info("{}", excercise.exercise2());
        LOGGER.info("{}", excercise.exercise3());
    }

    public String exercise1() {
        // TODO: find whether there are two employees with the same first name and surname and return the name

        Stream<Employee> stream = EMPLOYEES.stream();

        List<Employee> list = stream.filter(employee -> {

            Stream<Employee> innerSteam = EMPLOYEES.stream();

            List<Employee> innerList = innerSteam.filter(anotherEmployee ->
                    employee != anotherEmployee
                            && anotherEmployee.getSurname().equals(employee.getSurname())
                            && anotherEmployee.getFirstName().equals(employee.getFirstName())).limit(1).collect(Collectors.toList());

            return !innerList.isEmpty();

        }).limit(1).collect(Collectors.toList());

        return list.isEmpty() ? null : list.get(0).getFirstName() + " " + list.get(0).getSurname();
    }

    public long exercise2() {
        // TODO: find the total number of groups of at least 5 employees living close to each other
        // consider all employees with the same 2 first characters of the home address post code a single group

        Map<String, List<Employee>> groups = EMPLOYEES.stream().collect(Collectors.groupingBy(employee -> employee.getHomeAddress().getPostCode().substring(0, 2)));

        groups = groups.entrySet().stream().filter(group -> group.getValue().size() >= 5).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        return groups.size();
    }

    public List<String> exercise3() {
        DecimalFormat decimalFormat = new DecimalFormat("£#,###.00");
        // TODO: find how much in total each company pays to their employees, order result by amount
        // Barclays plc - £12,184,531.00
        Map<String, List<Employee>> groups = EMPLOYEES.stream().collect(Collectors.groupingBy(employee -> employee.getCompany().getName()));
        Map<String, String> sumSalaryForCompany = groups.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, group -> group.getValue().stream().map(Employee::getSalary).reduce(BigDecimal.valueOf(0), BigDecimal::add) + ""));
        Stream<String> result = sumSalaryForCompany.entrySet().stream()
                .sorted((e1,e2) -> (int) (Double.parseDouble(e1.getValue()) - Double.parseDouble(e2.getValue())))
                .map(entry -> entry.getKey() + " - " + decimalFormat.format(Double.parseDouble(entry.getValue())));
        return result.collect(Collectors.toList());
    }
}
