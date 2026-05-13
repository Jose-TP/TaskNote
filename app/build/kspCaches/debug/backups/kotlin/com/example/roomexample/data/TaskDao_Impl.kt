package com.example.roomexample.`data`

import androidx.lifecycle.LiveData
import androidx.room.EntityDeleteOrUpdateAdapter
import androidx.room.EntityInsertAdapter
import androidx.room.RoomDatabase
import androidx.room.util.getColumnIndexOrThrow
import androidx.room.util.performSuspending
import androidx.sqlite.SQLiteStatement
import javax.`annotation`.processing.Generated
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlin.collections.mutableListOf
import kotlin.reflect.KClass

@Generated(value = ["androidx.room.RoomProcessor"])
@Suppress(names = ["UNCHECKED_CAST", "DEPRECATION", "REDUNDANT_PROJECTION", "REMOVAL"])
public class TaskDao_Impl(
  __db: RoomDatabase,
) : TaskDao {
  private val __db: RoomDatabase

  private val __insertAdapterOfTask: EntityInsertAdapter<Task>

  private val __deleteAdapterOfTask: EntityDeleteOrUpdateAdapter<Task>

  private val __updateAdapterOfTask: EntityDeleteOrUpdateAdapter<Task>
  init {
    this.__db = __db
    this.__insertAdapterOfTask = object : EntityInsertAdapter<Task>() {
      protected override fun createQuery(): String = "INSERT OR ABORT INTO `tasks` (`id`,`title`,`description`,`isCompleted`) VALUES (nullif(?, 0),?,?,?)"

      protected override fun bind(statement: SQLiteStatement, entity: Task) {
        statement.bindLong(1, entity.id.toLong())
        statement.bindText(2, entity.title)
        statement.bindText(3, entity.description)
        val _tmp: Int = if (entity.isCompleted) 1 else 0
        statement.bindLong(4, _tmp.toLong())
      }
    }
    this.__deleteAdapterOfTask = object : EntityDeleteOrUpdateAdapter<Task>() {
      protected override fun createQuery(): String = "DELETE FROM `tasks` WHERE `id` = ?"

      protected override fun bind(statement: SQLiteStatement, entity: Task) {
        statement.bindLong(1, entity.id.toLong())
      }
    }
    this.__updateAdapterOfTask = object : EntityDeleteOrUpdateAdapter<Task>() {
      protected override fun createQuery(): String = "UPDATE OR ABORT `tasks` SET `id` = ?,`title` = ?,`description` = ?,`isCompleted` = ? WHERE `id` = ?"

      protected override fun bind(statement: SQLiteStatement, entity: Task) {
        statement.bindLong(1, entity.id.toLong())
        statement.bindText(2, entity.title)
        statement.bindText(3, entity.description)
        val _tmp: Int = if (entity.isCompleted) 1 else 0
        statement.bindLong(4, _tmp.toLong())
        statement.bindLong(5, entity.id.toLong())
      }
    }
  }

  public override suspend fun insert(task: Task): Unit = performSuspending(__db, false, true) { _connection ->
    __insertAdapterOfTask.insert(_connection, task)
  }

  public override suspend fun delete(task: Task): Unit = performSuspending(__db, false, true) { _connection ->
    __deleteAdapterOfTask.handle(_connection, task)
  }

  public override suspend fun update(task: Task): Unit = performSuspending(__db, false, true) { _connection ->
    __updateAdapterOfTask.handle(_connection, task)
  }

  public override fun getAllTasks(): LiveData<List<Task>> {
    val _sql: String = "SELECT * FROM tasks ORDER BY id DESC"
    return __db.invalidationTracker.createLiveData(arrayOf("tasks"), false) { _connection ->
      val _stmt: SQLiteStatement = _connection.prepare(_sql)
      try {
        val _columnIndexOfId: Int = getColumnIndexOrThrow(_stmt, "id")
        val _columnIndexOfTitle: Int = getColumnIndexOrThrow(_stmt, "title")
        val _columnIndexOfDescription: Int = getColumnIndexOrThrow(_stmt, "description")
        val _columnIndexOfIsCompleted: Int = getColumnIndexOrThrow(_stmt, "isCompleted")
        val _result: MutableList<Task> = mutableListOf()
        while (_stmt.step()) {
          val _item: Task
          val _tmpId: Int
          _tmpId = _stmt.getLong(_columnIndexOfId).toInt()
          val _tmpTitle: String
          _tmpTitle = _stmt.getText(_columnIndexOfTitle)
          val _tmpDescription: String
          _tmpDescription = _stmt.getText(_columnIndexOfDescription)
          val _tmpIsCompleted: Boolean
          val _tmp: Int
          _tmp = _stmt.getLong(_columnIndexOfIsCompleted).toInt()
          _tmpIsCompleted = _tmp != 0
          _item = Task(_tmpId,_tmpTitle,_tmpDescription,_tmpIsCompleted)
          _result.add(_item)
        }
        _result
      } finally {
        _stmt.close()
      }
    }
  }

  public companion object {
    public fun getRequiredConverters(): List<KClass<*>> = emptyList()
  }
}
