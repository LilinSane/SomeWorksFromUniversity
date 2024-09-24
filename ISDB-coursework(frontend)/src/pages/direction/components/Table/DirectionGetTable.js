import React, {useMemo, useState, useEffect} from 'react';
import { useTable} from 'react-table';


import './DirectionTable.css';
import {COLUMNS} from './GetColumns'


function GetTable({value}) {

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
                        <th {...column.getHeaderProps()}>{column.render('Header')}
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
                                return <td {...cell.getCellProps()}>{cell.render('Cell')}</td>
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

export default GetTable;
