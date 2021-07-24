import http from '@/http-common'

class TutorialDataService {
  getAll(): Promise<any> {
    return http.get('/tutorials')
  }

  get(id: any): Promise<any> {
    return http.get(`/tutorials/${id}`)
  }

  create(data: any): Promise<any> {
    return http.post('/tutorials', data)
  }

  update(id: any, data: any): Promise<any> {
    return http.put(`/tutorials/${id}`, data)
  }

  delete(id: any): Promise<any> {
    return http.put(`/tutorials/${id}`, id)
  }

  deleteAll(): Promise<any> {
    return http.delete('/tutorials')
  }

  findByTitle(title: string): Promise<any> {
    return http.get(`/tutorials?title=${title}`)
  }
}

export default new TutorialDataService()
