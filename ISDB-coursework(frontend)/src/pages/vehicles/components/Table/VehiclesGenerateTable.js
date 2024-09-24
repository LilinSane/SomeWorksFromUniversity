import React, {useMemo, useState, useEffect} from 'react';
import { useTable} from 'react-table';


import './VehiclesTable.css';
import {COLUMNS} from './GenerateColumns'


function GenerateTable({value}) {

  const [data, setData] = useState([]);

  const columns = useMemo(() => COLUMNS, []); 

  const { getTableProps,
    getTableBodyProps,
    headerGroups,
    rows,
    prepareRow} 
  = useTable({
    columns,
    data
});
  useEffect(() => { setData(value); })

  return (
    <>
    <table {...getTableProps()}>
        <thead>
            {headerGroups.map((headerGroup) => (
                <tr {...headerGroup.getHeaderGroupProps()}>
                    {headerGroup.headers.map((column) => (
                        <th style={{paddingLeft: 30, paddingRight: 30}} {...column.getHeaderProps()}>{column.render('Header')}
                        </th>
                    ))}
                </tr>
            ))}
        </thead>
        <tbody {...getTableBodyProps()}>
            {
                rows.map(row => {
                    prepareRow(row)
                    return (
                        <tr {...row.getRowProps()}>
                            {row.cells.map((cell) => {
                                return <td style={{paddingLeft: 30, paddingRight: 30}} {...cell.getCellProps()}>{cell.render('Cell')}</td>
                            })}
                        </tr>
                    )
                })
            }
        </tbody>
    </table>
    </>
  );
}

export default GenerateTable;
