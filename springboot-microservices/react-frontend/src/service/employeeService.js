import axios from 'axios';


const EMPLOYEE_API_BASE_URL = "http://localhost:9191/api/employees";
const EMPLOYEE_ID = "6";


class EmployeeService {

    getEmployees() {
        return axios.get(EMPLOYEE_API_BASE_URL + "/" + EMPLOYEE_ID);
    }
}

export default new EmployeeService();