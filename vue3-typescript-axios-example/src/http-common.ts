import axios, { AxiosInstance } from 'axios'

const apiClient: AxiosInstance = axios.create({
  baseURL: 'http://localhost:8888/adservices/v1/policies',
  headers: {
    'Content-type': 'application/json',
  },
})

export default apiClient
