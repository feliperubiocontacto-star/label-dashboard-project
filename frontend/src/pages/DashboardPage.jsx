import { useEffect, useState } from 'react';

const API = import.meta.env.VITE_API_BASE_URL || 'http://localhost:8080/api';

function DashboardPage() {
  const [tickets, setTickets] = useState([]);

  useEffect(() => {
    fetch(`${API}/tickets`)
      .then(r => r.json())
      .then(setTickets);
  }, []);

  const markCompleted = (t) => {
    fetch(`${API}/tickets/${t.id}`, {
      method: 'PUT',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify({ ...t, status: 'COMPLETADO' })
    })
      .then(r => r.json())
      .then(updated => {
        setTickets(prev => prev.map(x => x.id === updated.id ? updated : x));
      });
  };

  return (
    <main className="container dark">
      <h1>Tickets</h1>
      <table className="table">
        <thead>
          <tr>
            <th>ID</th><th>Cliente</th><th>Email</th><th>Status</th><th>Priority</th><th>Due</th><th></th>
          </tr>
        </thead>
        <tbody>
          {tickets.map(t => (
            <tr key={t.id} className={`row ${t.status.toLowerCase()}`}>
              <td>{t.id}</td>
              <td>{t.client}</td>
              <td>{t.senderEmail}</td>
              <td>{t.status}</td>
              <td className={t.priority === 'URGENCIA' ? 'urgent' : ''}>{t.priority}</td>
              <td>{t.dueDate}</td>
              <td>
                {t.status !== 'COMPLETADO' && (
                  <button onClick={() => markCompleted(t)}>✔</button>
                )}
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </main>
  );
}

export default DashboardPage;
