SELECT fh.Flavor from First_half fh left join (select flavor, sum(total_order) as total_order, shipment_id from july group by flavor) j on fh.shipment_id = j.shipment_id order by fh.total_order + j.total_order desc limit 3;

