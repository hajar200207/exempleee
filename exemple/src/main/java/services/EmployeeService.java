package services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import models.Employee;

public class EmployeeService {
    private List<Employee> employees;

    public EmployeeService() {
        // Initialisation de la liste des employés (peut être une base de données)
        employees = new ArrayList<>();
        // Exemple : Ajout de quelques employés pour la démonstration
        employees.add(new Employee(1, "John Doe", "john.doe@example.com", "123456789", "Marketing", "Manager"));
        employees.add(new Employee(2, "Jane Smith", "jane.smith@example.com", "987654321", "HR", "Recruiter"));
    }

    public List<Employee> getAllEmployees() {
        // Retourne tous les employés
        return employees;
    }

    public Employee getEmployeeById(int id) {
        // Retourne l'employé avec l'ID spécifié s'il existe, sinon null
        return employees.stream()
                        .filter(e -> e.getId() == id)
                        .findFirst()
                        .orElse(null);
    }

    public void addEmployee(Employee employee) {
        // Ajoute un nouvel employé à la liste
        // Pour une application réelle, vous voudrez peut-être vérifier les doublons, générer un ID unique, etc.
        employees.add(employee);
    }

    public void updateEmployee(Employee updatedEmployee) {
        // Met à jour les informations d'un employé existant
        // Ici, nous recherchons l'employé par son ID, puis mettons à jour ses informations
        for (int i = 0; i < employees.size(); i++) {
            Employee employee = employees.get(i);
            if (employee.getId() == updatedEmployee.getId()) {
                employees.set(i, updatedEmployee);
                break;
            }
        }
    }

    public void deleteEmployee(int id) {
        // Supprime l'employé avec l'ID spécifié
        employees = employees.stream()
                            .filter(e -> e.getId() != id)
                            .collect(Collectors.toList());
    }

    public List<Employee> searchEmployees(String keyword) {
        // Recherche les employés par nom, email, département, poste, etc. en fonction du mot-clé
        return employees.stream()
                        .filter(e -> e.getName().toLowerCase().contains(keyword.toLowerCase()) ||
                                     e.getEmail().toLowerCase().contains(keyword.toLowerCase()) ||
                                     e.getDepartment().toLowerCase().contains(keyword.toLowerCase()) ||
                                     e.getPosition().toLowerCase().contains(keyword.toLowerCase()))
                        .collect(Collectors.toList());
    }

    public List<Employee> filterEmployees(String department, String position) {
        // Filtrer les employés par département et/ou poste
        return employees.stream()
                        .filter(e -> (department == null || e.getDepartment().equalsIgnoreCase(department)) &&
                                     (position == null || e.getPosition().equalsIgnoreCase(position)))
                        .collect(Collectors.toList());
    }
}

