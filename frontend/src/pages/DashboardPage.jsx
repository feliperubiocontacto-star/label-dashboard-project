const demoTickets = [
  { id: 'TK-1001', title: 'Modificar Etiqueta - Producto A', status: 'PENDING' },
  { id: 'TK-1002', title: 'Modificar Etiqueta - Producto B', status: 'COMPLETED' },
  { id: 'TK-1003', title: 'Modificar Etiqueta - Producto C', status: 'PENDING' }
];

function DashboardPage() {
  return (
    <main className="container">
      <header>
        <h1>Label Modification Dashboard</h1>
        <p>Track generated tickets and completion progress.</p>
      </header>

      <section className="grid">
        {demoTickets.map((ticket) => (
          <article
            key={ticket.id}
            className={`card ${ticket.status === 'PENDING' ? 'pending' : 'completed'}`}
          >
            <h2>{ticket.id}</h2>
            <p>{ticket.title}</p>
            <span>{ticket.status}</span>
          </article>
        ))}
      </section>
    </main>
  );
}

export default DashboardPage;
