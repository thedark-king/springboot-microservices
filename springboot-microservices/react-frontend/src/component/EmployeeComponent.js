import React, { Component } from 'react';
import employeeService from '../service/employeeService';
import './EmployeeComponent.css';

class EmployeeComponent extends Component {
    constructor(props) {
        super(props);
        this.state = {
            employee: {},
            department: {},
            organization: {}
        }
    }

    componentDidMount() {
        employeeService.getEmployees().then((res) => {
             const employeeData = Array.isArray(res.data) ? res.data[0] : res.data;
             this.setState({ 
                employee: employeeData?.employee || {},
                department: employeeData?.department || {},
                organization: employeeData?.organization || {}
            }, () => {
                console.log('Employee State Updated:', this.state.employee);
                // console.log('Department State Updated:', this.state.department);
                // console.log('Organization State Updated:', this.state.organization);
            });
        }).catch((error) => {
            console.log(error);
        });
    }
    
    render() {
        const styles = {
            mainContainer: {
                minHeight: '100vh',
                background: 'linear-gradient(135deg, #667eea 0%, #764ba2 100%)',
                padding: '40px 20px',
                fontFamily: "'Segoe UI', Tahoma, Geneva, Verdana, sans-serif"
            },
            cardContainer: {
                backgroundColor: '#ffffff',
                borderRadius: '20px',
                boxShadow: '0 20px 60px rgba(0, 0, 0, 0.3)',
                overflow: 'hidden',
                animation: 'slideInUp 0.8s ease-out',
                marginTop: '20px'
            },
            cardBody: {
                padding: '40px'
            },
            mainHeading: {
                fontSize: '36px',
                fontWeight: '700',
                background: 'linear-gradient(135deg, #667eea 0%, #764ba2 100%)',
                WebkitBackgroundClip: 'text',
                WebkitTextFillColor: 'transparent',
                marginBottom: '30px',
                paddingBottom: '20px',
                borderBottom: '3px solid #e0e0e0',
                animation: 'fadeInDown 0.8s ease-out'
            },
            sectionCard: {
                padding: '25px',
                borderRadius: '15px',
                background: 'linear-gradient(135deg, #f5f7fa 0%, #c3cfe2 100%)',
                marginBottom: '20px',
                transition: 'all 0.4s cubic-bezier(0.4, 0, 0.2, 1)',
                cursor: 'pointer',
                animation: 'fadeInUp 1s ease-out',
                ':hover': {
                    transform: 'translateY(-10px)',
                    boxShadow: '0 15px 40px rgba(102, 126, 234, 0.3)'
                }
            },
            employeeCard: {
                background: 'linear-gradient(135deg, #667eea 0%, #764ba2 100%)',
                color: '#ffffff'
            },
            departmentCard: {
                background: 'linear-gradient(135deg, #f093fb 0%, #f5576c 100%)',
                color: '#ffffff'
            },
            organizationCard: {
                background: 'linear-gradient(135deg, #4facfe 0%, #00f2fe 100%)',
                color: '#ffffff'
            },
            sectionHeading: {
                fontSize: '20px',
                fontWeight: '700',
                marginBottom: '20px',
                paddingBottom: '12px',
                borderBottom: '2px solid rgba(255, 255, 255, 0.3)',
                display: 'flex',
                alignItems: 'center',
                gap: '10px'
            },
            icon: {
                fontSize: '24px'
            },
            paragraph: {
                fontSize: '15px',
                marginBottom: '15px',
                lineHeight: '1.8',
                display: 'flex',
                justifyContent: 'space-between',
                alignItems: 'center',
                padding: '10px 0',
                borderBottom: '1px solid rgba(255, 255, 255, 0.2)',
                transition: 'all 0.3s ease'
            },
            label: {
                fontWeight: '700',
                opacity: '0.9',
                minWidth: '130px'
            },
            value: {
                fontWeight: '600',
                opacity: '1',
                textAlign: 'right',
                flex: 1
            },
            rowContainer: {
                display: 'grid',
                gridTemplateColumns: 'repeat(3, 1fr)',
                gap: '25px',
                marginBottom: '30px'
            },
            fullWidthRow: {
                gridColumn: '1'
            }
        };

        return (
            <div style={styles.mainContainer}>
                <style>{`
                    @keyframes slideInUp {
                        from {
                            opacity: 0;
                            transform: translateY(40px);
                        }
                        to {
                            opacity: 1;
                            transform: translateY(0);
                        }
                    }
                    
                    @keyframes fadeInDown {
                        from {
                            opacity: 0;
                            transform: translateY(-20px);
                        }
                        to {
                            opacity: 1;
                            transform: translateY(0);
                        }
                    }
                    
                    @keyframes fadeInUp {
                        from {
                            opacity: 0;
                            transform: translateY(30px);
                        }
                        to {
                            opacity: 1;
                            transform: translateY(0);
                        }
                    }
                    
                    .info-card:hover {
                        transform: translateY(-10px);
                        box-shadow: 0 15px 40px rgba(0, 0, 0, 0.15);
                    }
                    
                    .info-card p:last-child {
                        border-bottom: none;
                    }
                    
                    .info-card p:hover {
                        background: rgba(255, 255, 255, 0.1);
                        padding: 12px 10px;
                        border-radius: 8px;
                    }
                `}</style>
                
                <div className="container" style={styles.cardContainer}>
                    <div style={styles.cardBody}>
                        <h2 style={styles.mainHeading} className='text-center'>📊 Employee Management System</h2>
                        
                        <div style={styles.rowContainer}>
                            {/* Employee Card */}
                            <div style={{...styles.sectionCard, ...styles.employeeCard}} className="info-card">
                                <h5 style={styles.sectionHeading}>
                                    <span style={styles.icon}>👤</span>
                                    Employee Information
                                </h5>
                                <p style={styles.paragraph} className='text-start'>
                                    <span style={styles.label}>First Name:</span>
                                    <span style={styles.value}>{this.state.employee.firstName || 'N/A'}</span>
                                </p>
                                <p style={styles.paragraph} className='text-start'>
                                    <span style={styles.label}>Last Name:</span>
                                    <span style={styles.value}>{this.state.employee.lastName || 'N/A'}</span>
                                </p>
                                <p style={styles.paragraph} className='text-start'>
                                    <span style={styles.label}>Email:</span>
                                    <span style={styles.value}>{this.state.employee.email || 'N/A'}</span>
                                </p>
                            </div>
                            
                            {/* Department Card */}
                            <div style={{...styles.sectionCard, ...styles.departmentCard}} className="info-card">
                                <h5 style={styles.sectionHeading}>
                                    <span style={styles.icon}>🏢</span>
                                    Department Information
                                </h5>
                                <p style={styles.paragraph} className='text-start'>
                                    <span style={styles.label}>Name:</span>
                                    <span style={styles.value}>{this.state.department.departmentName || 'N/A'}</span>
                                </p>
                                <p style={styles.paragraph} className='text-start'>
                                    <span style={styles.label}>Description:</span>
                                    <span style={styles.value}>{this.state.department.departmentDescription || 'N/A'}</span>
                                </p>
                                <p style={styles.paragraph} className='text-start'>
                                    <span style={styles.label}>Code:</span>
                                    <span style={styles.value}>{this.state.department.departmentCode || 'N/A'}</span>
                                </p>
                            </div>
                            
                            {/* Organization Card */}
                            <div style={{...styles.sectionCard, ...styles.organizationCard, ...styles.fullWidthRow}} className="info-card">
                                <h5 style={styles.sectionHeading}>
                                    <span style={styles.icon}>🌐</span>
                                    Organization Information
                                </h5>
                                <p style={styles.paragraph} className='text-start'>
                                    <span style={styles.label}>Name:</span>
                                    <span style={styles.value}>{this.state.organization.organizationName || 'N/A'}</span>
                                </p>
                                <p style={styles.paragraph} className='text-start'>
                                    <span style={styles.label}>Description:</span>
                                    <span style={styles.value}>{this.state.organization.organizationDescription || 'N/A'}</span>
                                </p>
                                <p style={styles.paragraph} className='text-start'>
                                    <span style={styles.label}>Code:</span>
                                    <span style={styles.value}>{this.state.organization.organizationCode || 'N/A'}</span>
                                </p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        );
    }
}

export default EmployeeComponent;