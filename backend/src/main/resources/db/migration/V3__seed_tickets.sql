INSERT INTO tickets (created_at, sender_email, client, type, description, due_date, status, priority, thread_id, approval_token)
VALUES
(NOW(), 'ventas@cliente1.com', 'Cliente 1', 'NUEVA', 'Crear etiqueta producto A', CURRENT_DATE + 2, 'PENDIENTE', 'URGENCIA', 'thr1', 'tok1'),
(NOW(), 'ventas@cliente2.com', 'Cliente 2', 'CORRECCION', 'Corregir error lote', CURRENT_DATE + 5, 'EN_PROCESO', 'ETIQUETA', 'thr2', 'tok2'),
(NOW(), 'ventas@cliente3.com', 'Cliente 3', 'REVISION', 'Revisar normativa', CURRENT_DATE + 3, 'PENDIENTE', 'URGENCIA', 'thr3', 'tok3'),
(NOW(), 'ventas@cliente4.com', 'Cliente 4', 'CONFIRMADA', 'Confirmar etiqueta final', CURRENT_DATE + 1, 'COMPLETADO', 'ETIQUETA', 'thr4', 'tok4'),
(NOW(), 'ventas@cliente5.com', 'Cliente 5', 'NUEVA', 'Nueva etiqueta exportación', CURRENT_DATE + 7, 'PENDIENTE', 'URGENCIA', 'thr5', 'tok5'),
(NOW(), 'ventas@cliente6.com', 'Cliente 6', 'CORRECCION', 'Actualizar código barras', CURRENT_DATE + 4, 'EN_PROCESO', 'ETIQUETA', 'thr6', 'tok6'),
(NOW(), 'ventas@cliente7.com', 'Cliente 7', 'REVISION', 'Revisión idioma etiqueta', CURRENT_DATE + 6, 'PENDIENTE', 'ETIQUETA', 'thr7', 'tok7'),
(NOW(), 'ventas@cliente8.com', 'Cliente 8', 'NUEVA', 'Etiqueta urgente campaña', CURRENT_DATE + 1, 'PENDIENTE', 'URGENCIA', 'thr8', 'tok8'),
(NOW(), 'ventas@cliente9.com', 'Cliente 9', 'CONFIRMADA', 'Confirmación QA', CURRENT_DATE + 2, 'COMPLETADO', 'ETIQUETA', 'thr9', 'tok9'),
(NOW(), 'ventas@cliente10.com', 'Cliente 10', 'CORRECCION', 'Corrección traducción', CURRENT_DATE + 3, 'EN_PROCESO', 'URGENCIA', 'thr10', 'tok10');
